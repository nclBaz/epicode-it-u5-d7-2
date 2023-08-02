package riccardogulin.u5d7.payloads;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class NewPrenotazioneBody {
	int userId;
	int prenotazioneId;
	LocalDate date;
}
