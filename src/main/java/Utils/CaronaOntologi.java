/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 *
 * @author Jair
 */
public class CaronaOntologi {
        protected static final String uri ="http://www.trabalho2ws.com/carona-rdf/1.0#";
    
    public static String getURI() {
          return uri;
    }
    
    private static Model m = ModelFactory.createDefaultModel();
    
    public static final Resource MOTORISTA = m.createResource(uri + "MOTORISTA");
    public static final Resource PASSAGEIRO = m.createResource(uri + "PASSAGEIRO");
    public static final Property LOCALORIGEM = m.createProperty(uri, "LOCALORIGEM");
    public static final Property LOCALDESTINO = m.createProperty(uri, "LOCALDESTINO");
    public static final Property LOCALINTERMEDIARIO = m.createProperty(uri, "LOCALINTERMEDIARIO");
    public static final Property NOMEVEICULO = m.createProperty(uri, "NOMEVEICULO");
}
