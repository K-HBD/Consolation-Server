package K.HBD.domain.sentence;

import K.HBD.domain.enumType.Emotion;
import K.HBD.domain.enumType.Use;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@DynamicUpdate
public class Sentence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sentence_letter", nullable = false, unique = true)
    private String letter;

    @Builder.Default
    @Column(name = "used_letter", nullable = false)
    @Enumerated(EnumType.STRING)
    private Use used_letter = Use.NOT_USED_LETTER;

    @Column(name = "emotion", nullable = false)
    @Enumerated(EnumType.STRING)
    private Emotion emotion;

    public void update(Use used_letter) {
        this.used_letter = used_letter;
    }

}
