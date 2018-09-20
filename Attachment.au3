$count = 0

While $count <> 10

$hd1 = WinActivate("Open")

	If $hd1 <> 0 Then
		ControlFocus("Open", "","Edit1")
		Sleep(1000)
		ControlSetText("Open","","Edit1","")
		Sleep(1000)
		ControlClick("Open", "","Button1")
		Exit
		EndIf

		Sleep(1000)

		$count = $count + 1

		WEnd