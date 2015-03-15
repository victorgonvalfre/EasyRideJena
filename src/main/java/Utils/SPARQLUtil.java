/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.hp.hpl.jena.query.ParameterizedSparqlString;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolutionMap;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.util.FileManager;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Victor
 */
public enum SPARQLUtil {
    
    INSTANCE;
	
	public static void printQuery(String queryString, String inputFileName)
	{
		 
		Model model = loadRDF(inputFileName);
		
		Query query = QueryFactory.create(queryString); 
        
		QueryExecution queryExecution = QueryExecutionFactory.create(query,model);
        
        ResultSet results = queryExecution.execSelect();
        
        ResultSetFormatter.out(System.out, results, query) ;
        
        queryExecution.close();
	}
	
	public static void printQueryParameterizedString(String queryString, String inputFileName, String parameter, String value)
	{
		 
		Model model = loadRDF(inputFileName);
		
		ParameterizedSparqlString queryStr = new ParameterizedSparqlString(queryString);
		
		queryStr.setLiteral(parameter, value);
		
		Query query = QueryFactory.create(queryStr.toString()); 
        
		QueryExecution queryExecution = QueryExecutionFactory.create(query,model);
        
        ResultSet results = queryExecution.execSelect();
        
        ResultSetFormatter.out(System.out, results) ;
        
        queryExecution.close();
	}
	
	
	public static void printQueryMAP(String queryString, String inputFileName, String parameter, String value)
	{
		 
		Model model = loadRDF(inputFileName);
		
		RDFNode node = model.createResource(value);
		
		QuerySolutionMap map = new QuerySolutionMap();
		
		map.add(parameter, node);
		
		Query query = QueryFactory.create(queryString); 
        
		QueryExecution queryExecution = QueryExecutionFactory.create(query,model, map);
        
        ResultSet results = queryExecution.execSelect();
        
        ResultSetFormatter.out(System.out, results) ;
     
        queryExecution.close();
     
	}
	
	
	private static Model loadRDF(String inputFileName) {
		// create an empty model
		Model model = ModelFactory.createDefaultModel();

		// use the FileManager to find the input file
		InputStream in = FileManager.get().open(inputFileName);

		if (in == null) {
			throw new IllegalArgumentException("File: " + inputFileName
					+ " not found");
		}

		// read the RDF/XML file
		model.read(new InputStreamReader(in), "");
		
		return model;
	}
	
	public static  ResultSet dbpediaQuery (String query)
	{
		QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
		
		ResultSet results = queryExecution.execSelect();
		
		return results;
	}
	
	public static  ResultSet externalQuery (String query, String serviceURL)
	{
		QueryExecution queryExecution = QueryExecutionFactory.sparqlService(serviceURL, query);
		
		ResultSet results = queryExecution.execSelect();
		
		return results;
	}
	
}
