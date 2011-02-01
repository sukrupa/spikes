require 'rubygems'
require 'roo'
   
   HOURLY_RATE = 123.45
   
   oo = Excelx.new("simple_spreadsheet.xlsx")
   oo.default_sheet = oo.sheets.first
   4.upto(5) do |line|
    date = oo.cell(line,'A')
    start_time = oo.cell(line,'B')
    end_time   = oo.cell(line,'C')
    pause      = oo.cell(line,'D')
	sum        = Integer((end_time - start_time) - pause)
    comment    = oo.cell(line,'F')
	amount     = sum * HOURLY_RATE
   if date
    puts "#{date}\t#{sum}\t#{amount}\t#{comment}"
		end
		end