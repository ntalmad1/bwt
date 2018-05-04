package com.talmadge.bwt.core.client.http;

/**
 * 
 *
 */
public enum HttpStatusCode
{
	/**
     * The request has succeeded.
     */
    _200_SUCCESS_OK(200, "SUCCESS: OK"), 
    
    /**
     * The request has been fulfilled and resulted in a new resource being
     * created.
     */
    _201_SUCCESS_CREATED(201, "SUCCESS: Created"),
    
    /**
     * The server has fulfilled the request but does not need to return an
     * entity-body (for example after a DELETE), and might want to return
     * updated meta-information.
     */
    _204_SUCCESS_NO_CONTENT(204, "SUCCESS: No Content"),
    
    /**
     * The request could not be understood by the server due to malformed
     * syntax.
     */
    _400_ERROR_BAD_REQUEST(400, "ERROR: Bad Request"),
    
	/**
     * The request requires user authentication.
     */
    _401_ERROR_UNAUTHORIZED(401, "ERROR: Unauthorized"),
    
    /**
     * The server has not found anything matching the Request-URI or the server
     * does not wish to reveal exactly why the request has been refused, or no
     * other response is applicable.
     */
    _404_ERROR_NOT_FOUND(404, "ERROR: Not Found"),
    
    /**
     * The server encountered an unexpected condition which prevented it from
     * fulfilling the request.
     */
    _500_INTERNAL_SERVER_ERROR(500, "ERROR: Internal Server Error");
	
	//-------------------------------------------------------------------------------
	
	/**
	 */
	private int code;
	
	/**
	 */
	private String desc;
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param code int 
	 */
	private HttpStatusCode (int code, String desc)
	{
		this.code = code;
		this.desc = desc;
	}
	
	
	/**
	 * 
	 * @return String
	 */ 
	public String getDesc ()
	{
		return this.desc;
	}
	
	
	/**
	 * 
	 * @return int
	 */
	public int getInt ()
	{
		return this.code;
	}
}
