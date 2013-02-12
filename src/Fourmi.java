
public class Fourmi {

	private int nbOuvrier;
	private int nbSoldat;
	private int nbNourrice;
	private final static int MAXFOURMI=8;
	private final static int MAXNOURRICE=8;
	private int nbFourmi= nbOuvrier+nbSoldat;
	
	public Fourmi(){
		nbOuvrier=2;
		nbNourrice=3;
		nbSoldat=0;
	}

	public int getNbFourmi() {
		return nbFourmi;
	}

	public int getNbOuvrier() {
		return nbOuvrier;
	}

	public void setNbOuvrier(int nbOuvrier) {
		this.nbOuvrier = nbOuvrier;
	}

	public void ajouterOuvrier(){
		if(nbFourmi+1<MAXFOURMI){
			nbOuvrier++;
		}
	}
	
	public void enleverOuvrier(){
		if(nbOuvrier-1<0){
			System.out.println("On ne peut pas enlever d'ouvrier");
		}
		else{
			nbOuvrier--;
		}
	}
	public int getNbSoldat() {
		return nbSoldat;
	}

	public void setNbSoldat(int nbSoldat) {
		this.nbSoldat = nbSoldat;
	}

	public void ajouterSoldat(){
		if(nbFourmi+1<MAXFOURMI){
			nbSoldat++;
		}
	}
	
	public void enleverSoldat(){
		if(nbSoldat-1<0){
			System.out.println("On ne peut pas enlever de soldat");
		}
		else{
			nbSoldat--;
		}
	}
	public int getNbNourrice() {
		return nbNourrice;
	}

	public void setNbNourrice(int nbNourrice) {
		this.nbNourrice = nbNourrice;
	}
	
	public void ajouterNourrice(){
		if(nbFourmi+1<MAXNOURRICE){
			nbNourrice++;
		}
	}
	
	public void enleverNourrice(){
		if(nbNourrice-1<0){
			System.out.println("On ne peut pas enlever de nourrice");
		}
		else{
			nbNourrice--;
		}
	}
	
}
