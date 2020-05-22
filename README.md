# kotagiri-hybris

First commit of SAP CX (Hybris) HAC Impex Import Audit.

To Use this extension. Please download it and keep it in the customer folder and below line in the localextensions.xml for this extension to be part of your build.

<extension name="hacimpexaudit" />

This extension buit using 1905 version of hybris. Below are the properties that this extension makes use of to enable HAC impex import audit tracking.

##Configs to enable HAC impex import auditing into hacimpexaudit table - 6.7 HAC Impex Facade class
#hac.impex.import.facade.class.name=de.hybris.platform.hac.facade.impl.DefaultImpexFacade

##Configs to enable HAC impex import auditing into hacimpexaudit table - 1905 HAC Impex Facade class
hac.impex.import.facade.class.name=de.hybris.platform.hac.facade.HacImpexFacade

impex.cron.job.remove.on.success=true

#Below property enables hmcsavedvalues which track the changes on the records as OOTB audit of itemtypes. Typically administration tab last changes
impex.import.hmcsavedvaluesenabled=true
