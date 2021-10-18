Asynchronous Queue/Collection

- Display reactiveness (handling messages) and proactiveness (generating new messages based on internal state or local time)

Generic Autonomous Agent 
- InBox
- OutBox
- Memory / Collection
- Collection of Message handlers
- Collection of Behaviours

Simple Autonomous Agent 

- Has one handler that filters messages for the keyword “hello” and prints the whole message to stdout
- Has one behaviour that generates random 2-word messages from an alphabet of 10 words (“hello”, “sun”, “world”, “space”, “moon”, “crypto”, “sky”, “ocean”, “universe”, “human”) every 2 seconds


ConcurrentLinkedQueue is a good class for the goal