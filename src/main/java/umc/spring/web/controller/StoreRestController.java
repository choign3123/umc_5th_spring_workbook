package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.service.MissionService.IMissionCommandService;
import umc.spring.service.StoreService.IStoreCommandService;
import umc.spring.web.dto.StoreRequest;
import umc.spring.web.dto.StoreResponse;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
@Slf4j
public class StoreRestController {

    private final IStoreCommandService storeCommandService;
    private final IMissionCommandService missionCommandService;

    /**
     * 특정 지역에 가게 추가하기
     * @param request
     * @return
     */
    @PostMapping("")
    public ResponseDto<StoreResponse.CreateStoreDTO> createStore(@RequestBody StoreRequest.CreateStoreDTO request){

        Store newStore = storeCommandService.createStore(request);

        return ResponseDto.onSuccess(StoreResponse.toCreateStoreDTO(newStore), Code.OK);
    }

    /**
     * 가게에 미션 추가하기
     */
    @PostMapping("/{store-id}/mission")
    public ResponseDto<StoreResponse.CreateMissionDTO> createMission(@PathVariable("store-id")Long storeId, @RequestBody StoreRequest.CreateMissionDTO request){

        Mission newMission = missionCommandService.createMission(storeId, request);

        return ResponseDto.onSuccess(StoreResponse.toCreateMissionDTO(newMission), Code.OK);
    }

}
