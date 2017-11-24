import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Requisicao implements Runnable{

    private Socket socket;
    
    public Requisicao (Socket socket) {
        this.socket = socket;
    }
    
    public void run () 
    {
        InputStream ip = null;
        RequisicaoHTTP reqHTTP = new RequisicaoHTTP();
        String primeiraLinha [] = null;
        StringBuilder sb = new StringBuilder();
        Map<String, String> mapaParametros = new HashMap<String,String>();
        int numberReq = 0;
        
        try {
            ip = socket.getInputStream();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {
			while((numberReq = ip.read()) != -1) {
				if (numberReq != 13 && numberReq != 10) 
				{
					sb.append((char)numberReq);
					
				}//ADICIONA TODOS OS CARACTERES
				else if (numberReq == 10 && primeiraLinha == null) 
				{
					primeiraLinha = sb.toString().split(" ");
					reqHTTP.setModo(primeiraLinha[0]);
					reqHTTP.setRecurso(primeiraLinha[1]);
					reqHTTP.setVersaoHTTP(primeiraLinha[2]);
					sb = new StringBuilder(); 
					
				}//REALIZA O TRATAMENTO DA PRIMEIRA LINHA
				else if (numberReq == 10 && primeiraLinha != null) 
				{
					
					if (sb.length() > 0)
					{
						int indexSeparador = sb.toString().indexOf(":");
						String chave = sb.toString().substring(0, indexSeparador);
						String valor = sb.toString().substring(indexSeparador + 1, sb.length());
						mapaParametros.put(chave, valor);
						reqHTTP.setParametros(mapaParametros);
						sb = new StringBuilder(); 
					}
				}//REALIZA O TRATAMENTO DAS DEMAIS LINHAS
			}//WHILE
			System.out.println("REQUISICAO HTTP: " + reqHTTP);
			ip.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}


