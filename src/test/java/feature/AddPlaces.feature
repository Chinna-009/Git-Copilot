Feature: Validating Places APIs


@AddPlace @Regression
Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI

        
         Given Add Place Paylod "<name>" "<language>" "<address>"
         When User call "addPlaceAPI" with "Post" http request
         Then The API call is success with status code 200
         And "status" in the response body is "OK"
         And "scope" in the response body is "APP"
         And Verify PlaceID created addplaceAPImaps and Verify name should match to "<name>" using "getPlaceAPI"
         
         
Examples: 
         |name        | language   | address              | 
         |Chinna House| Tamil      | Indian Trade Centre  |
         |Chinna House| Russian    | Russian Trade Centre |
         |Chinna House| Japanese   | Japanese Trade Centre|
         
@DelPlace @Regression      
Scenario: Verify delete functionality is working or not 
      Given Del Place Payload   
      When User call "deletePlaceAPI" with "Post" http request
      Then The API call is success with status code 200
      And "status" in the response body is "OK"    
                                                                                  
       
       
           
                                                                                                   
                                          
         
             
                                             
                             
                                                       
                    
         
          
            
                
          
         
                                                               
      