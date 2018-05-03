Sub Totalyear()

''Easy part
' Declare Total is total volume of each ticker per year
Dim Total As Double
' Declare ticker_name as is name of each ticker
Dim ticker_name As String
' Declare r as the row will be used to print out every ticker's total volume
Dim r As Long
r = 2

' Look up to every sheet in workbook
For Each w_sheet In Worksheets

'Look up from row number 2 to last row of every sheet

 For n = 2 To w_sheet.Cells(Rows.count, 1).End(xlUp).Row
 
 'In case of next row's value is different with value of current row, meaning this is last row of this ticker
 
  If w_sheet.Cells(n + 1, 1).Value <> w_sheet.Cells(n, 1).Value Then
  
       'After learned that this is the last row then take this ticker name for print out
       ticker_name = w_sheet.Cells(n, 1).Value

      ' Also add to the last ticker row's volume to total amount of this ticker
      Total = Total + w_sheet.Cells(n, 7).Value

      ' Print out the tickers name
      w_sheet.Cells(1, 9).Value = "Ticker"
      w_sheet.Cells(r, 9).Value = ticker_name

      ' Display the total amount of each tickers
      w_sheet.Cells(1, 10).Value = "Total Stock Volume"
      w_sheet.Cells(r, 10).Value = Total

      ' Aftter print out then reset the total volume to Zero before using this for next ticker
      Total = 0
      ' Together increase 1 for the row to print out next volume
      r = r + 1
    Else
     ' Add to the ticker's volume to total volume of each tickers in case of ticker name of current cell and is same with the next.
     Total = Total + w_sheet.Cells(n, 7).Value
   End If
   
Next n
'Reset r value after finishing counting  to count on another sheet
r = 2
Next w_sheet

End Sub


