package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/header")
    public ResponseDto<Integer> includeHeader(@RequestHeader("value") int value){
        return ResponseDto.onSuccess(value, Code.OK);
    }

    @GetMapping("/header2")
    public ResponseDto<Integer> includeHeader2(@RequestHeader(value = "value", required = false) int value){
        return ResponseDto.onSuccess(value, Code.OK);
    }

    @GetMapping("/header3")
    public ResponseDto<Integer> includeHeader3(@RequestHeader(name = "value_id") int value){
        return ResponseDto.onSuccess(value, Code.OK);
    }

    @GetMapping("/header4")
    public ResponseDto<Integer> includeHeader4(@RequestHeader("value-id") int value){
        return ResponseDto.onSuccess(value, Code.OK);
    }

    @GetMapping("/body")
    public ResponseDto<Integer> includeBody(@RequestBody int value){
        return ResponseDto.onSuccess(value, Code.OK);
    }
}
