package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.util.DateUtils;
import com.appsflyer.share.Constants;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;

public class QueryStringSigner extends AbstractAWSSigner implements Signer {
    private Date overriddenDate;

    public void sign(Request<?> request, AWSCredentials credentials) throws AmazonClientException {
        sign(request, SignatureVersion.V2, SigningAlgorithm.HmacSHA256, credentials);
    }

    public void sign(Request<?> request, SignatureVersion version, SigningAlgorithm algorithm, AWSCredentials credentials) throws AmazonClientException {
        String stringToSign;
        if (!(credentials instanceof AnonymousAWSCredentials)) {
            AWSCredentials sanitizedCredentials = sanitizeCredentials(credentials);
            request.addParameter("AWSAccessKeyId", sanitizedCredentials.getAWSAccessKeyId());
            request.addParameter("SignatureVersion", version.toString());
            request.addParameter("Timestamp", getFormattedTimestamp(getTimeOffset(request)));
            if (sanitizedCredentials instanceof AWSSessionCredentials) {
                addSessionCredentials(request, (AWSSessionCredentials) sanitizedCredentials);
            }
            if (version.equals(SignatureVersion.V1)) {
                stringToSign = calculateStringToSignV1(request.getParameters());
            } else if (version.equals(SignatureVersion.V2)) {
                request.addParameter("SignatureMethod", algorithm.toString());
                stringToSign = calculateStringToSignV2(request);
            } else {
                throw new AmazonClientException("Invalid Signature Version specified");
            }
            request.addParameter("Signature", signAndBase64Encode(stringToSign, sanitizedCredentials.getAWSSecretKey(), algorithm));
        }
    }

    private String calculateStringToSignV1(Map<String, String> parameters) {
        StringBuilder data = new StringBuilder();
        SortedMap<String, String> sorted = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sorted.putAll(parameters);
        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            data.append(entry.getKey());
            data.append(entry.getValue());
        }
        return data.toString();
    }

    private String calculateStringToSignV2(Request<?> request) throws AmazonClientException {
        URI endpoint = request.getEndpoint();
        Map<String, String> parameters = request.getParameters();
        StringBuilder data = new StringBuilder();
        data.append("POST").append("\n");
        data.append(getCanonicalizedEndpoint(endpoint)).append("\n");
        data.append(getCanonicalizedResourcePath(request)).append("\n");
        data.append(getCanonicalizedQueryString(parameters));
        return data.toString();
    }

    private String getCanonicalizedResourcePath(Request<?> request) {
        String resourcePath = "";
        if (request.getEndpoint().getPath() != null) {
            resourcePath = resourcePath + request.getEndpoint().getPath();
        }
        if (request.getResourcePath() != null) {
            if (resourcePath.length() > 0 && !resourcePath.endsWith(Constants.URL_PATH_DELIMITER) && !request.getResourcePath().startsWith(Constants.URL_PATH_DELIMITER)) {
                resourcePath = resourcePath + Constants.URL_PATH_DELIMITER;
            }
            resourcePath = resourcePath + request.getResourcePath();
        } else if (!resourcePath.endsWith(Constants.URL_PATH_DELIMITER)) {
            resourcePath = resourcePath + Constants.URL_PATH_DELIMITER;
        }
        if (!resourcePath.startsWith(Constants.URL_PATH_DELIMITER)) {
            resourcePath = Constants.URL_PATH_DELIMITER + resourcePath;
        }
        if (resourcePath.startsWith("//")) {
            return resourcePath.substring(1);
        }
        return resourcePath;
    }

    private String getFormattedTimestamp(int offset) {
        SimpleDateFormat df = new SimpleDateFormat(DateUtils.ISO8601_DATE_PATTERN);
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (this.overriddenDate != null) {
            return df.format(this.overriddenDate);
        }
        return df.format(getSignatureDate(offset));
    }

    /* access modifiers changed from: package-private */
    public void overrideDate(Date date) {
        this.overriddenDate = date;
    }

    /* access modifiers changed from: protected */
    public void addSessionCredentials(Request<?> request, AWSSessionCredentials credentials) {
        request.addParameter("SecurityToken", credentials.getSessionToken());
    }
}
