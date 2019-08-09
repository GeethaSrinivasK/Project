package comm.example.activityservice.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="User Not Found")
public class NoSuchActivityException extends Exception {
	
	private static final long serialVersionUID = 4809435150327655330L;

	public NoSuchActivityException(String arg0) {
		super(arg0);
	}
	
	
}
