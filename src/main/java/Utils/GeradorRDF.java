/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import Model.Carona;
import Model.Lugar;
import Model.Pessoa;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Victor
 */
public class GeradorRDF extends AbstractQuery {
    
    
     public void gerarRdf(List<Carona> lstCarona) throws IOException{
        String personIRI = "Http://www.EasyRide.br/";
        
        Resource newCarona;
        
        Model model = ModelFactory.createDefaultModel();
        
        for(Carona caronas: lstCarona){
            newCarona = model.createResource(personIRI + caronas.getID());
            
            Resource n = model.createResource();
            n.addProperty(CaronaOntologi.CNH, caronas.motorista.getCnh());
            newCarona.addProperty(CaronaOntologi.PESSOAMOTORISTA, n);
            
            Resource c = model.createResource();
            c.addProperty(CaronaOntologi.PLACA, caronas.motorista.veiculo.getPlaca());
            c.addProperty(CaronaOntologi.MODELO, caronas.motorista.veiculo.getModelo());
            c.addProperty(CaronaOntologi.VAGAS, caronas.getVagasString());
            newCarona.addProperty(CaronaOntologi.CARRO, c);
 
            Resource n1 = model.createResource();
            n1.addProperty(CaronaOntologi.NOME, caronas.motorista.getPessoa().getNome() );
            n1.addProperty(CaronaOntologi.EMAIL, caronas.motorista.getPessoa().getEmail() );
            n1.addProperty(CaronaOntologi.ENDRECO, caronas.motorista.getPessoa().getEndereco() );
            n1.addProperty(CaronaOntologi.TELL, caronas.motorista.getPessoa().getTelefone() );
            newCarona.addProperty(CaronaOntologi.PESSOAMOTORISTA, n1);
            
            Resource n2 = model.createResource();
            n2.addProperty(CaronaOntologi.NOMELOCAL, caronas.saida.getNome() );
            n2.addProperty(CaronaOntologi.DESCRICAO, caronas.saida.getDescricao());
            newCarona.addProperty(CaronaOntologi.LOCALSAIDA, n2);
            
            Resource lugarDestino;
            for(Lugar destinos: caronas.lstDestinos){
                lugarDestino = model.createResource();
                lugarDestino.addProperty(CaronaOntologi.NOMELOCAL, destinos.getNome() );
                lugarDestino.addProperty(CaronaOntologi.DESCRICAO, destinos.getDescricao());
                newCarona.addProperty(CaronaOntologi.LOCALDESTINO, lugarDestino);
            }
            
            Resource pessoaCarona;
            for(Pessoa caronistas : caronas.lstPessoasParaCarona){
                pessoaCarona = model.createResource();
                pessoaCarona.addProperty(CaronaOntologi.NOME, caronistas.getNome() );
                pessoaCarona.addProperty(CaronaOntologi.EMAIL, caronistas.getEmail() );
                pessoaCarona.addProperty(CaronaOntologi.ENDRECO, caronistas.getEndereco() );
                pessoaCarona.addProperty(CaronaOntologi.TELL, caronistas.getTelefone() );
                newCarona.addProperty(CaronaOntologi.PESSOAPASSAGEIRO, pessoaCarona);   
            }
        }
        
                 
        FileWriter out;
        out = new FileWriter(inputFileName);
        model.write( out,"RDF/XML" );
        out.close();
        System.out.println("Arquivo gerado com sucesso: " + inputFileName);
    }
    
}
