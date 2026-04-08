package riccardogulin.u5d2.entities;

import org.springframework.stereotype.Component;

@Component
public class Interviewer {
	// Esempio di ACCOPPIAMENTO MOLTO FORTE
	// private Student student = new BackendStudent("Aldo", "Baglio"); // Questa è una DIPENDENZA nei confronti di un'altra classe

	private Student student;

//	public Interviewer(FullStackStudent student) {
//		this.student = student;
//	}

	public Interviewer(Student student) { // ACCOPPIAMENTO DEBOLE
		// E' debole perché Interviewer non si crea un oggetto student, bensì viene passato dall'esterno.
		// Inoltre usando l'astrazione (in questo caso la classe astratta Student, ma potrebbe essere anche un'interfaccia)
		// abbiamo un sacco di benefici per quanto riguarda testabilità, manutenibilità ecc ecc
		this.student = student;
	}

	public void askQuestion() {
		System.out.println("Ciao " + student.getName() + ", rispondimi alla seguente domanda...blablabla");
		this.student.answerQuestion();
	}
}
