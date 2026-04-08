package riccardogulin.u5d2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import riccardogulin.u5d2.entities.FrontendStudent;
import riccardogulin.u5d2.entities.Interviewer;

@SpringBootApplication
public class U5d2Application {

	public static void main(String[] args) {
		SpringApplication.run(U5d2Application.class, args);
		// ********************************* METODO TRADIZIONALE ****************************************
//		FrontendStudent aldo = new FrontendStudent("Aldo", "Baglio");
//		Interviewer interviewer = new Interviewer(aldo);
//		interviewer.askQuestion();

		// *********************************** LEGGERE BEAN DAL CONTEXT *********************************
		// 1. Ottengo un riferimento al context
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5d2Application.class);

		// 2. Tramite il metodo .getBean() posso leggere dallo scatolone i bean o tramite NOME DEL BEAN o tramite TIPO
		FrontendStudent aldoFromCtx = ctx.getBean(FrontendStudent.class);
		aldoFromCtx.setName("Aldo");
		System.out.println(aldoFromCtx);


		FrontendStudent aldoFromCtx2 = ctx.getBean(FrontendStudent.class);
		System.out.println(aldoFromCtx2);

//		BackendStudent giovaFromCtx = ctx.getBean(BackendStudent.class);
//		System.out.println(giovaFromCtx);
//
		Interviewer interviewerFromCtx = ctx.getBean(Interviewer.class);

		interviewerFromCtx.askQuestion();


		// Se voglio posso leggere i Bean anche per nome. Il nome di default è il nome del metodo Bean

//		FrontendStudent fesFromContext = ctx.getBean("getFEStudent", FrontendStudent.class);
//		System.out.println(fesFromContext);
//
//		// Volendo posso sovrascrivere il nome di default usando @Bean(name = "nome_bean")
//		BackendStudent besFromContext = ctx.getBean("giova", BackendStudent.class);
//		System.out.println(besFromContext);
//
//		Faker f = ctx.getBean(Faker.class);
//		System.out.println(f.animal().name());
	}

}
