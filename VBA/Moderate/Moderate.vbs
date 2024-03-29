Sub Totalyear()

'' Easy part
' Declare Total is total volume of each ticker per year
Dim Total As Double
' Declare Sticker_name as is name of each ticker
Dim Ticker_name As String
' Declare r to set the row number will be used to print out every ticker's total volume
Dim r As Long
r = 2

'' Moderate part. I applied Yearly Change and Percent Change by Wall street based - formulas: Closed price of the last day of that year - Opened price of the first day of that year and Percent Change : (Closed price - Opened price)/Opened price
' Declare Open_price and Close_Price as prices of first and last transaction of each Ticker per yearly
Dim Open_price As Double
Dim Close_price As Double
Open_price = 0
Close_price = 0

' Declare count_last to find the row position that contain Closed price of each Ticker yearly
Dim count_last As Long
count_last = 1
' Declare count_first to find the row position that contain Opened price of each Ticker yearly
Dim count_first As Long
count_first = 2

' Look up to every sheet in workbook
For Each w_sheet In Worksheets

'Look up from row number 2 to last row of every sheet

 For n = 2 To w_sheet.Cells(Rows.count, 1).End(xlUp).Row
 
 'In case of next row's value is different with value of current row, meaning this is last row of this ticker
 
   If w_sheet.Cells(n + 1, 1).Value <> w_sheet.Cells(n, 1).Value Then
  
       'After learned that this is the last row then take this ticker name for print out
        Ticker_name = w_sheet.Cells(n, 1).Value

      ' Also add to the last ticker row's volume to total amount of this ticker
       Total = Total + w_sheet.Cells(n, 7).Value
       
      ' Also add to the last row of this sticker to find out the position(Closed price) this ticker
       count_last = count_last + 1
       
      ' Assign the value for closed price and opened price after getting the position
       Close_price = w_sheet.Cells(count_last, 6).Value
       Open_price = w_sheet.Cells(count_first, 3).Value
      ' The  last row contains the closed price of each sticker increase 1 that will is opened price of another ticker's position
       count_first = count_last + 1
       
      ' Checking the last row number of each ticker
      ' w_sheet.Cells(r, 8).Value = count_last
      ' Checking total of opening/Opened prices yearly
      ' w_sheet.Cells(1, 11).Value = "Open Price"
      ' w_sheet.Cells(r, 11).Value = Open_price
      ' Checking total of closing/Closed prices yearly
      ' w_sheet.Cells(1, 12).Value = "Closing Price"
      ' w_sheet.Cells(r, 12).Value = Close_price

      ' Print out the Tickers name
       w_sheet.Cells(1, 9).Value = "Ticker"
       w_sheet.Cells(r, 9).Value = Ticker_name
      
      ' Calculating Yearly Change by opened and closed prices yearly
       w_sheet.Cells(1, 10).Value = "Yearly Change"
       w_sheet.Cells(r, 10).Value = Close_price - Open_price
       
      '  Calculating Percent Change but Double divide double problem as sometimes occurs error runtime "6" Overflow especially when divide value begin with Zero, using IF to strap this error
      
      If Open_price > 0 Then
       w_sheet.Cells(1, 11).Value = "Percent Change"
       w_sheet.Cells(r, 11).Value = (Close_price - Open_price) / Open_price
       w_sheet.Cells(r, 11).NumberFormat = "0.00%"
      End If

      ' Print out the total volume of each tickers
      w_sheet.Cells(1, 12).Value = "Total Stock Volume"
      w_sheet.Cells(r, 12).Value = Total
         
      ' Conditional formatting that will highlight positive Yearly Change in green and negative change in red
       If w_sheet.Cells(r, 10).Value < 0 Then
         w_sheet.Cells(r, 10).Interior.ColorIndex = 3
       Else
         w_sheet.Cells(r, 10).Interior.ColorIndex = 10
       End If
         
      ' Aftter print out then reset the total volume to Zero before using for next ticker
        Total = 0
      ' Together increase 1 for the row to print out next volume
        r = r + 1
      ' After print out then reset Opened price and closed price to Zero beforing using for next ticker
        Open_price = 0
        Close_price = 0
    Else
     ' Add to the ticker's volume to total volume of each stickers in case of next ticker name and current value is same value
       Total = Total + w_sheet.Cells(n, 7).Value
     
     ' In case next ticker and current sticker is same value then count_last increase 1
       count_last = count_last + 1
    End If
   
Next n
'Reset r value after finishing counting on every sheet to begin  counting on another sheet
 r = 2
'Reset Count_last and count_first value after finishing counting on every sheet before  counting on another sheet
 count_last = 1
 count_first = 2

Next w_sheet

End Sub
