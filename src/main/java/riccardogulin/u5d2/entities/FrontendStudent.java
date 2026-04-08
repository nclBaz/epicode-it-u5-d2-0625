package riccardogulin.u5d2.entities;

public class FrontendStudent extends Student {
	public FrontendStudent(String name, String surname) {
		super(name, surname);
	}

	@Override
	public void answerQuestion() {
		System.out.println("Ciao sono lo studente Frontend ecco la risposta alla domanda...blablabla");
	}
}
