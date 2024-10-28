package pl.engineer.active.substances.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.engineer.active.substances.dto.InfoDTO;
import pl.engineer.active.substances.exception.CategoryException;
import pl.engineer.active.substances.exception.ContractorException;

@ControllerAdvice
public class ExceptionAdviceController {
    @ExceptionHandler
    public ResponseEntity<InfoDTO> handleCategoryException(CategoryException e) {
        return ResponseEntity.ok(new InfoDTO("dsa"));
//        return ResponseHelper.response400(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<InfoDTO> handleContractorException(ContractorException e) {
        return ResponseHelper.response400(e.getMessage());
    }


}
