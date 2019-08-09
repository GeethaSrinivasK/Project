package comm.example.regservice.Errors;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController{
	
	@ExceptionHandler
	public ResponseEntity<RunTime_Errors> handleException(NoSuchUserException nsue){
		RunTime_Errors re = new RunTime_Errors(new Timestamp(System.currentTimeMillis()) , nsue.getMessage(), HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<RunTime_Errors>(re , HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<RunTime_Errors> handleException(Exception exc){
		RunTime_Errors re = new RunTime_Errors(new Timestamp(System.currentTimeMillis()) , "Unique index or primary key violation", 4260);
		
		return new ResponseEntity<RunTime_Errors>(re , HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
