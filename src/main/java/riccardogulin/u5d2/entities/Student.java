package riccardogulin.u5d2.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Student {
	//	@Setter(AccessLevel.NONE) // Non autogenerare il setter per questo campo
//	private UUID uuid;
	private String name;
	private String surname;

	public abstract void answerQuestion();

}
