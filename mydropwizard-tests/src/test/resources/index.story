Scenario:  Story index is retrieved from REST provider.  Stories are loaded and uploaded.

Given REST provider is SimpleService
When index is retrieved from http://localhost:9000/simple-service
Then the index is not empty