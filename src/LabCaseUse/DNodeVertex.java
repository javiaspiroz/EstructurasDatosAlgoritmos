package LabCaseUse;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public class DNodeVertex {

	public String vertex;
	public Float weight;
	
	public DNodeVertex prev;
	public DNodeVertex next;
	
	public DNodeVertex(String v, Float w) {
		vertex = v;
		weight = w;
	}

}

