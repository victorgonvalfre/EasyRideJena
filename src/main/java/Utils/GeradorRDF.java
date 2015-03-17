/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import Model.Carona;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Jair
 */
public class GeradorRDF extends AbstractQuery {
    
    
     public void gerarRdf(List<Carona> lstCarona) throws IOException{
        String personIRI = "Http://www.EasyRide.br/";
        
        Resource newCarona;
        
        Model model = ModelFactory.createDefaultModel();
        
        for(Carona caronas: lstCarona){
            newCarona = model.createResource(personIRI + caronas.getID());
//            newCarona.addProperty(CaronaOntologi.MOTORISTA, caronas.getMotorista().getPessoa().getNome());
 
          
            
    
        }
        
                 
        FileWriter out;
        out = new FileWriter(inputFileName);
        model.write( out,"RDF/XML" );
        out.close();
        System.out.println("Arquivo gerado com sucesso: " + inputFileName);
    }
    
}
