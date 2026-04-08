package riccardogulin.u5d2.config;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import riccardogulin.u5d2.entities.BackendStudent;
import riccardogulin.u5d2.entities.FrontendStudent;
import riccardogulin.u5d2.entities.FullStackStudent;

import java.util.Locale;

@Configuration
@PropertySource("application.properties")
public class ConfigClass {
	/*
	Questa sarà una classe speciale all'interno dell'applicazione
	Essa conterrà le dichiarazioni dei BEAN (oggetti gestiti da Spring)
	Con questa classe ed i suoi metodi sto praticamente chiedendo a Spring "Gestisci tu questo oggetto, creandolo
	ed aggiungendolo allo "scatolone" (Application Context) all'avvio dell'applicazione"
	I vari Bean saranno definiti tramite metodi annotati con @Bean
	*/

	@Bean
	public int getNumber() {
		return 42;
	}

	@Bean
	public String getAdminName(@Value("${postgres.password}") String name) {
		return name;
	}

//	@Bean
//	public String getAdminName2() {
//		return "Antonino";
//	}

	@Bean
	@Scope("prototype") // Scope è un'annotazione OPZIONALE, di default sono tutti SINGLETON
	// SINGLETON = in tutta l'applicazione esiste un'UNICA COPIA dell'oggetto. Ogni volta che faccio .getBean() mi tornerà sempre lo stesso
	// PROTOTYPE = ogni volta che faccio .getBean() mi tornerà una NUOVA COPIA dell'oggetto

	public FrontendStudent getFEStudent(String name) { // @Value mi permette di leggere i valori dalle variabili
		// dentro application.properties (non dimenticare di specificare @PropertySource("application.properties")
		return new FrontendStudent(name, "Baglio");
	}

	@Bean(name = "giova")
	public BackendStudent getBEStudent() {
		return new BackendStudent("Giovanni", "Storti");
	}

	@Bean(name = "giova2")
	public BackendStudent getBEStudent2() {
		return new BackendStudent("Giovanni", "Storti2");
	}

	@Bean(name = "giacomino")
	// @Primary // Il Primary diventa una sorta di caso di default
	// Quindi, se ci dovessero essere ambiguità (cioè Spring non sa quale Bean
	// scegliere), verrebbe scelto questo Bean Primary come "ultima spiaggia"
	public FullStackStudent getFSStudent() {
		return new FullStackStudent("Giacomo", "Poretti");
	}

	@Bean
	public Faker getFaker() {
		return new Faker(Locale.ITALIAN);
	}

	//	@Bean
//	public Interviewer getInterviewer(Student student) {
//		// Il parametro student si dice che è una DIPENDENZA di Interviewer
//		// Quindi Spring non solo crea oggetti, ma è anche in grado di
//		// risolvere le dipendenze andando a cercare nello scatolone
//		// se ci siano dei Bean compatibili (per tipo o per nome). Se li trova li passa ad Interviewer
//		// Se ne dovesse trovare zero segnala errore e l'applicazione non parte
//		// Anche se ne dovesse trovare più di uno con lo stesso tipo l'applicazione non partirebbe
//		return new Interviewer(student);
//	}
}
