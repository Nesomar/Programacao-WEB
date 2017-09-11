
import java.util.HashMap;
import java.util.Map;

public class RequisicaoHTTP {
    
    private String modo;
    private String recurso;
    private String versaoHTTP;
    private Map<String, String> parametros = new HashMap<String,String>();
    
    
    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public String getVersaoHTTP() {
        return versaoHTTP;
    }

    public void setVersaoHTTP(String versaoHTTP) {
        this.versaoHTTP = versaoHTTP;
    }

    public Map<String, String> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, String> parametros) {
        this.parametros = parametros;
    }

    public String getParametro (String chave) {
        String parametroRetorno = null;
        if (this.parametros.containsKey(chave)) 
        {
            parametroRetorno = this.parametros.get(chave);
        }else 
        {
            return parametroRetorno;
        }
        
        return parametroRetorno;
    }
    
    @Override
	public String toString() {
		return "RequisicaoHTTP [modo=" + modo + ", recurso=" + recurso + ", versaoHttp=" + versaoHTTP + ", mapa="
				+ parametros + "]";
    }

}

