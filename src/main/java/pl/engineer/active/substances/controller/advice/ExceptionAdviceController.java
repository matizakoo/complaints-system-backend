package pl.tanielazienki.tanielazienki.controller.advice;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.tanielazienki.tanielazienki.controller.CategoryController;
import pl.tanielazienki.tanielazienki.controller.advice.ResponseHelper;
import pl.tanielazienki.tanielazienki.dto.InfoDTO;
import pl.tanielazienki.tanielazienki.exception.CategoryException;
import pl.tanielazienki.tanielazienki.exception.ContractorException;

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
