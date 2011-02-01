http://roo.rubyforge.org/

roo for some reason doesn't install its own dependencies. the list of gems needed is: 
bones (3.6.2)
builder (3.0.0)
google-spreadsheet-ruby (0.1.2)
little-plugger (1.1.2)
loquacious (1.7.0)
nokogiri (1.4.4)
oauth (0.4.4)
rake (0.8.7)
roo (1.9.3)
ruby-ole (1.2.11.1)
rubyzip (0.9.4)
spreadsheet (0.6.5.1)

We achieved our goal of importing a small excel file and reading it into the command line by using a small roo script. But we are planning to use poi for the "real" story, not roo because
- roo doesn't import our own dependencies
- if we use roo we will have to install more things on the server
- if we use roo we will have to use jruby to interface between ruby and java. 
