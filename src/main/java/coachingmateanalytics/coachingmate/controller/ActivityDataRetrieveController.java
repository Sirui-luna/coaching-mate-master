package coachingmateanalytics.coachingmate.controller;

import coachingmateanalytics.coachingmate.entity.Statistic;
import coachingmateanalytics.coachingmate.service.ActivityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Date: 24/9/20 15:51
 * @Description:
 */
@Controller
@RequestMapping("/activity")
//@CrossOrigin("http://localhost:3000")
public class ActivityDataRetrieveController {
    @Autowired
    ActivityService activityService;

    @GetMapping("/getAllByUsername")
    @ApiOperation(value = "retrieve Data By Username", notes = "query all activity data of specific user")
    public ResponseEntity<List<Statistic>> retrieveDataByUser(@ApiParam(required = true, type = "String") @RequestParam("username") String username){
        List<Statistic> allByUsername = activityService.findAllByUsername(username);
        return ResponseEntity.ok(allByUsername);
    }

    @GetMapping("/getAllByAccessToken")
    @ApiOperation(value = "retrieve Data By Username", notes = "query all activity data of specific user")
    public ResponseEntity<List<Statistic>> retrieveDataByaccessToken(@ApiParam(required = true, type = "String") @RequestParam("accessToken") String accessToken){
        List<Statistic> allByaccessToken = activityService.findAllByAccessToken(accessToken);
        return ResponseEntity.ok(allByaccessToken);
    }
}
