# sudokuSolver
A small application that is used to solve a sudoku puzzle of easy to medium difficulty. If the puzzle is harder than that, it will more than likely require a more complex algorithm to intuit what the most likely values will be.

I have coded revisions of this applications out previously (in Java, js, and PL/SQL), but have never stored a solution in a permanent place.

### Execution
```
git clone https://github.com/ajesk/sudoku-solver.git
cd sudoku-solver
gradle run
```

### Nomenclature
* Grid  = all 81 boxes
* Cell  = individual box
* Segment = grouping of 9 boxes
* Box   = square 9 cell segment
* Column = vertical 9 cell segment
* Row = horizontal 9 cell segment
