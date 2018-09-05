 ShellExecute("chrome.exe", $cmdLine[1] & " --new-window --start-maximized")
 sleep(2000)
 
 Send("^s")
 Sleep(1500);
 
 WinWaitActive("[TITLE:Save As]", "", 15)
 Sleep(1500)

 Send($CmdLine[2])
 Sleep(1500);
 
 Send("{ENTER}")
 Sleep(1500)
 
 Send("^w")