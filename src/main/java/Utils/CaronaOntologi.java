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
 * @author Victor
 */
public class CaronaOntologi {
        protected static final String uri ="http://www.trabalho2ws.com/carona-rdf/1.0#";
    
    public static String getURI() {
          return uri;
    }
    
    private static Model m = ModelFactory.createDefaultModel();
    
    public static final Resource MOTORISTA = m.createResource(uri + "MOTORISTA");
    public static final Resource PASSAGEIRO = m.createResource(uri + "PASSAGEIRO");
    public static final Resource VEICULO = m.createResource(uri + "VEICULO");
    public static final Resource DESTINO = m.createResource(uri + "DESTINO");
    
    public static final Property PESSOAMOTORISTA = m.createProperty(uri, "PESSOAMOTORISTA");
    public static final Property PESSOAPASSAGEIRO = m.createProperty(uri, "PESSOAPASSAGEIRO");
    public static final Property CNH = m.createProperty(uri, "CNH");
    public static final Property NOME = m.createProperty(uri, "NOME");
    public static final Property EMAIL = m.createProperty(uri, "EMAIL");
    public static final Property TELL = m.createProperty(uri, "TELL");
    public static final Property ENDRECO = m.createProperty(uri, "ENDRECO");

    public static final Property CARRO = m.createProperty(uri, "CARRO");
    public static final Property MODELO = m.createProperty(uri, "MODEL");
    public static final Property PLACA = m.createProperty(uri, "PLACA");
    public static final Property VAGAS = m.createProperty(uri, "VAGAS");
    
    
    public static final Property LOCALSAIDA = m.createProperty(uri, "LOCALSAIDA");
    public static final Property LOCALDESTINO = m.createProperty(uri, "LOCALDESTINO");
    public static final Property NOMELOCAL = m.createProperty(uri, "NOMELOCAL");
    public static final Property DESCRICAO = m.createProperty(uri, "DESCRICAO");
}
