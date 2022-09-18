
Objective:
A simple RMI messaging application to implement and practise the useful Gof Design patterns(Strategy and Mediator) for this scenario.
The app has been implemented in pure Java. Unit tests has been implemented and will be run with each build to ensure the code coverage.
For more information about the application technical documentation please refer to documentation.txt file.

To launch the application in single PID mode. please follow the steps below:

	1. run the launchSinglePID.sh file and type any message afterwards and press enter.

	2. After the first message is typed the application will start to send and receive 10 messages and then stops.

To launch the application in Multiple PIDs mode(should exit the single PID mode first), please follow the steps below:

	1. run the launch_server_MultiplePID.sh file.

	2. run the launch_initiator_MultiplePID.sh file in another terminal.

	3. run launch_receiver_MultiplePID.sh file in another terminal.

	4. type a message in the initiator shell to start the conversation.

	5. After the first message is typed the application will start to send and receive 10 messages and then stops.


