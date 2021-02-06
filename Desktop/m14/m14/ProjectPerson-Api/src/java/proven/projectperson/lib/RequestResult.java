/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proven.projectperson.lib;

/**
 *
 * @author Waner Kevin
 */
public class RequestResult {
    /**
     * Data to sent
     */
    
    private Object data;
    
    /**
     * Result code to be sent
     */
    private int resultCode;

    public RequestResult(Object data, int resultCOde) {
        this.data = data;
        this.resultCode = resultCOde;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getResultCOde() {
        return resultCode;
    }

    public void setResultCOde(int resultCOde) {
        this.resultCode = resultCOde;
    }

    @Override
    public String toString() {
        //return "RequestResult{" + "data=" + data + ", resultCOde=" + resultCOde + '}';
        StringBuilder sb = new StringBuilder();
        sb.append("ProjectPersonRequestResult{").append("data=");
        sb.append(data).append("resultCode=").append(resultCode).append("}");
        return sb.toString();       
    }
    
    
   
    
    
}

