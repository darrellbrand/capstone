
C)

mainscreen.html lines 14 and 19 I changed the title and header tags to 'joes electronics shop'.



D)

about.html and AboutController.java are created.
mainscreen.html line 89 added a link to go back to home page.


E)
BootStrapData.java line 38 created method addSampleParts(). Line 81 add method addSampleProducts().
Line 96 if statement to check if lists are empty and if so call both new methods.


F) Created BuyProductController.java,FailureController.java,SuccessController.java, success.html,failure.html.
I linked the mapping up so the new templates can be displayed in respective controllers with @notation.
mainscreen.html line 85 added a button that will decrement the product inventory by one on and display success message on success or show fail message on failure.


G)
BootStrap.data method addSampleParts() line 38 I added the minInv andMaxInv fields.
AddInHousePartController and  AddOutSourcePartController have been modified at line 39 where the if statement now
checks to see if the inv is in range of the minInv and maxInv values.
Part.java has been modifed to have a method isInventoryValid() that returns true if inventory is valid.
InhousePartForm.html and OutsourcedPartForm.html have been modified at line 26 -30 to add min and max inv inputs.