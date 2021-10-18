# Full Stack Java

## Week 1 - Core Java

### Create a GitHub account
* Go to https://github.com/
* If you already have a GitHub account login into your account
* If you don't have a GitHub account, click on 'Sign Up' and complete the 'Sign Up' process.
* After completion of 'Sign Up' process, login into your GitHub account.

### Install Git
* Go to the link https://git-scm.com/downloads
* Click on the download link.
* Run the installation file to initiate the installation.
* During installation leave the default options as it is in each screen settings and complete the installation.
* Once installation is completed, click on Start Menu and check if you are able to find 'Git Bash' and click on this.
* If it opens a command link window, it means that Git is installed successfully.
* Right click on the Git Bash icon in the taskbar and select "Pin to Taskbar" to permanently have this icon in the taskbar, which makes it easier to quickly launch Git Bash.

### Clone GitHub FSD Java folder structure
* Ensure that you are logged into into your GitHub account
* Open the link https://github.com/jjchandru/revature-fsd-java in the browser
* Click the 'Fork' option available in the top right corner
* This will make a copy of the 'revature-fsd-java` repository into your GitHub account in the GitHub server.
* Choose a convenient folder in your Laptop or Desktop PC where you want to store all the source code that you will develop as part of this training.
* Open that folder in your "Windows File Explorer"
* Right click on the empty space of the right hand side of the 'File Explorer' window and select 'Git Bash here' option
* Then run the following command which will create the entire folder structure that you will use to store all the source files of your project.
* `git clone https://github.com/[your-github-user-name]/revature-fsd-java.git`
* In the 'File Explorer', now you will be able to see the 'revature-fsd-java' folder which will contain subfolders to manage all the source code.

### Install JDK 8
* Open google.com in browser and search for "jdk 8 download"
* Click on the link titled "Java SE Development Kit 8 - Downloads"
* Scroll down to the section starting with "Java SE Development Kit 8u...". In this section scroll down to the table to Windows x64. Choose other respective link based on your operating system.
* Click on the respective installable exe file to download.
* This will open a popup window to accept the license agreement.
* Click the accept checkbox and click on 'download'
* Clicking on download will show a login page.
* Sign up and create an Oracle account using the Create Account option.
* After sign up, login into the newly created Oracle Account and complete the download.
* Once downloaded run the executable file and follow the instructions to install JDK 8.
* After the installation completes, open a command prompt and run the command `javac -version` which should display the version, which means that JDK is successfully installed.

### Install Spring Tool Suite (STS)
* Open the below link in the browser which will download a file name with '.jar' extension.
`https://download.springsource.com/release/STS4/4.6.2.RELEASE/dist/e4.15/spring-tool-suite-4-4.6.2.RELEASE-e4.15.0-win32.win32.x86_64.self-extracting.jar`
* Move the downloaded jar file to 'C:\Users\[your-windows-user-name]' folder.
* Then double click on the jar file which will create a new folder named "sts-4.6.2.RELEASE"
* Go into this folder and double click on SpringToolSuite4.exe, which will launch Spring Tools Suite.
* There will be a screen that requests for the workspace folder.
* Select 'sts-workspace' folder from the 'revature-fsd-java' Git folder which had been already cloned.
* This will launch STS.
* After launching right click on the STS icon in the taskbar and select 'Pin to Taskbar' which will make the STS icon permanently available in taskbar and can be opened instantly using this icon instead of using the start menu or navigating to the folder.