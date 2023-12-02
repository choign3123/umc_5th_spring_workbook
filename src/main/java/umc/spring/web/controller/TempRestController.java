package umc.spring.web.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.TempConverter;
import umc.spring.service.TempService.ITempQueryService;
import umc.spring.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final ITempQueryService tempQueryService;

    @GetMapping("/test")
    public ResponseDto<TempResponse.TempTestDTO> testAPI(){
        return ResponseDto.onSuccess(TempConverter.toTempTestDTO(), Code.OK);
    }

    @GetMapping("/exception")
    public ResponseDto<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){

        tempQueryService.CheckFlag(flag);

        return ResponseDto.onSuccess(TempConverter.toTempExceptionDTO(flag), Code.OK);
    }
}
