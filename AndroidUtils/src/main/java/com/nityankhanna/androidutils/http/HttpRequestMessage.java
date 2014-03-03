package com.nityankhanna.androidutils.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nityan Khanna on Jan 18 2014.
 */

/**
 * Represents an Http request message.
 */
public final class HttpRequestMessage extends HttpRequest {

	private ContentType contentType;
	private List<HttpCookie> cookies;
	private Encoding encoding;
	private List<HttpHeader> headers;
	private List<HttpParameter> params;
	private RequestType requestType;
	private String url;

	/**
	 * Initializes a new instance of the HttpRequestMessage class with a url and request type.
	 * <p/>
	 * This is used for GET and DELETE Requests
	 *
	 * @param url         The url.
	 * @param requestType The request type.
	 */
	public HttpRequestMessage(String url, RequestType requestType) {
		this.url = url;
		this.requestType = requestType;
		cookies = new ArrayList<>();
		headers = new ArrayList<>();
		params = new ArrayList<>();
	}

	/**
	 * Initializes a new instance of the HttpRequestMessage class with a url, request type, content type and encoding.
	 * </p>
	 * This is used for POST and PUT requests.
	 *
	 * @param url         The url.
	 * @param requestType The request type.
	 * @param contentType The content type.
	 * @param encoding    The encoding.
	 */
	public HttpRequestMessage(String url, RequestType requestType, ContentType contentType, Encoding encoding) {
		this(url, requestType);
		this.contentType = contentType;
		this.encoding = encoding;
	}

	/**
	 * Gets the request type.
	 *
	 * @return Returns the request type.
	 */
	@Override
	public RequestType getRequestType() {
		return requestType;
	}

	/**
	 * Gets the url.
	 *
	 * @return Returns the url.
	 */
	@Override
	public String getUrl() {
		return url;
	}

	/**
	 * Adds a cookie to the collection.
	 *
	 * @param cookie The cookie.
	 */
	@Override
	public void addCookie(HttpCookie cookie) {
		removeDuplicateCookie(cookie);

		if (!cookie.isExpired(new Date())) {
			cookies.add(cookie);
		}
	}

	/**
	 * Adds a cookie to the collection at the specified index.
	 *
	 * @param index  The index.
	 * @param cookie The cookie.
	 */
	@Override
	public void addCookie(int index, HttpCookie cookie) {
		removeDuplicateCookie(cookie);
		cookies.add(index, cookie);
	}

	/**
	 * Gets a list of cookies.
	 *
	 * @return Returns a list of cookies.
	 */
	@Override
	public List<HttpCookie> getCookies() {
		return cookies;
	}

	/**
	 * Clears the expired cookies from the collection.
	 *
	 * @param date The date.
	 */
	@Override
	public void clearExpired(Date date) {

		for (Iterator<HttpCookie> it = cookies.iterator(); it.hasNext(); ) {

			if (it.next().isExpired(date)) {
				it.remove();
			}
		}
	}

	/**
	 * Removes a cookie from the collection.
	 *
	 * @param cookie The cookie.
	 */
	@Override
	public void removeCookie(HttpCookie cookie) {
		cookies.remove(cookie);
	}

	/**
	 * Removes a cookie from the collection at the specified index.
	 *
	 * @param index The index.
	 */
	@Override
	public void removeCookie(int index) {
		cookies.remove(index);
	}

	/**
	 * Removes all cookies from the collection.
	 */
	@Override
	public void removeAllCookies() {
		cookies.clear();
	}

	/**
	 * Removes a duplicate cookie.
	 *
	 * @param cookie The cookie.
	 */
	@Override
	public void removeDuplicateCookie(HttpCookie cookie) {

		for (Iterator<HttpCookie> it = cookies.iterator(); it.hasNext(); ) {
			if (cookie.equals(it.next())) {
				it.remove();
				break;
			}
		}
	}

	/**
	 * Adds an Http header to the request.
	 *
	 * @param header The Http header to add to the collection.
	 */
	@Override
	public void addHeader(HttpHeader header) {
		removeDuplicateHeader(header);
		headers.add(header);
	}

	/**
	 * Adds an Http header to the collection at the specified index.
	 *
	 * @param index  The index of where to add the header.
	 * @param header The Http header to add to the collection.
	 */
	@Override
	public void addHeader(int index, HttpHeader header) {
		removeDuplicateHeader(header);
		headers.add(index, header);
	}

	/**
	 * Returns a list of Http headers.
	 *
	 * @return Returns a list of Http headers.
	 */
	@Override
	public List<HttpHeader> getHeaders() {
		return headers;
	}

	/**
	 * Removes an Http Header.
	 *
	 * @param header The Http header to be removed.
	 */
	@Override
	public void removeHeader(HttpHeader header) {
		headers.remove(header);
	}

	/**
	 * Removes the header at the specified index.
	 *
	 * @param index The index of the header.
	 */
	@Override
	public void removeHeader(int index) {
		headers.remove(index);
	}

	/**
	 * Removes all of the Http headers.
	 */
	@Override
	public void removeAllHeaders() {
		headers.clear();
	}

	/**
	 * Removes a duplicate header.
	 *
	 * @param header The Http header to be removed.
	 */
	@Override
	public void removeDuplicateHeader(HttpHeader header) {

		for (Iterator<HttpHeader> it = headers.iterator(); it.hasNext(); ) {
			if (header.equals(it.next())) {
				it.remove();
				break;
			}
		}
	}

	/**
	 * Adds an HttpParameter to the collection.
	 *
	 * @param parameter The HttpParameter to add.
	 */
	@Override
	public void addParameter(HttpParameter parameter) {
		removeDuplicateParameter(parameter);
		params.add(parameter);
	}

	/**
	 * Adds an HttpParameter to the collection at the specified index.
	 *
	 * @param index     The index.
	 * @param parameter The HttpParameter to add.
	 */
	@Override
	public void addParameter(int index, HttpParameter parameter) {
		removeDuplicateParameter(parameter);
		params.add(index, parameter);
	}

	/**
	 * Gets a list of HttpParameters.
	 *
	 * @return Returns a list of HttpParameters.
	 */
	@Override
	public List<HttpParameter> getParameters() {
		return params;
	}

	/**
	 * Removes a parameter.
	 *
	 * @param parameter The HttpParameter to be removed.
	 */
	@Override
	public void removeParameter(HttpParameter parameter) {
		params.remove(parameter);
	}

	/**
	 * Removes the parameter at the specified index.
	 *
	 * @param index The index.
	 */
	@Override
	public void removeParameter(int index) {
		params.remove(index);
	}

	/**
	 * Removes all the parameters from the collection.
	 */
	@Override
	public void removeAllParameters() {
		params.clear();
	}

	/**
	 * Removes a duplicate parameter.
	 *
	 * @param parameter The HttpParameter to be removed.
	 */
	@Override
	public void removeDuplicateParameter(HttpParameter parameter) {

		for (Iterator<HttpParameter> it = params.iterator(); it.hasNext(); ) {
			if (parameter.equals(it.next())) {
				it.remove();
				break;
			}
		}
	}

	/**
	 * Checks if the Http message contains cookies.
	 *
	 * @return Returns true if the Http message contains cookies.
	 */
	@Override
	public boolean containsCookies() {
		return cookies.size() > 0;
	}

	/**
	 * Checks if the Http message contains headers.
	 *
	 * @return Returns true if the Http message contains headers.
	 */
	@Override
	public boolean containsHeaders() {
		return headers.size() > 0;
	}

	/**
	 * Checks if the Http message contains parameters.
	 *
	 * @return Returns true if the Http message contains parameters.
	 */
	@Override
	public boolean containsParameters() {
		return params.size() > 0;
	}

	/**
	 * Gets the content type of the message.
	 *
	 * @return Returns the content type.
	 */
	@Override
	public ContentType getContentType() {
		return contentType;
	}

	/**
	 * Gets the encoding of the message.
	 *
	 * @return Returns the encoding.
	 */
	@Override
	public Encoding getEncoding() {
		return encoding;
	}
}
