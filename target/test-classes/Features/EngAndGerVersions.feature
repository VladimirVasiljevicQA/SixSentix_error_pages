Feature: Verify some page existent, on english and german
.
@all @pass
Scenario: Go to -About Us- page with english language on app
Given i go to homepage sixsentix
When i turn off alert
And i move cursor on Life In Sixsentix
And i click on About Us
Then i see About Us page

@all @fail_1
Scenario: Go to -About Us- page with german language on app
Given i go to homepage sixsentix DE
When i turn off alert DE
And i click on DE
And i move cursor on Leben In Sixsentix
And i click on Über uns
Then i see Über uns page

@all @fail_2
Scenario: Go to -Contact- page with german language on app
Given i go to homepage sixsentix DE2
When i turn off alert DE2
And i click on DE2
And i move cursor on Leben In Sixsentix2
And i click on Kontakt
Then i see Kontakt page