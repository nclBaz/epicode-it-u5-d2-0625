package riccardogulin.u5d2.entities;

public class BackendStudent extends Student {
	public BackendStudent(String name, String surname) {
		super(name, surname);
	}

	@Override
	public void answerQuestion() {
		System.out.println("Ciao sono lo studente Backend ecco la risposta alla domanda...blablabla");
	}

}
