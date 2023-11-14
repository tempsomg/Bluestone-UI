package Utils;

public interface webElements {

	// Query Editor Elements
	// ------------------------------------------------------------------------
	final String SelectValueLink1 = "select value";
	final String Selectaddcondition = "//*[@id=\"FLOATING_BASE_ROOT_ID\"]/div[4]/div[1]/div/div/div[2]/div[2]/div[1]/div/div[1]/div/button[1]"; //Somu
	final String SelectLabel1 = "//*[@id=\"FLOATING_BASE_ROOT_ID\"]/div[4]/div[1]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]"; //Somu
	final String SelectLabel1sub = "//*[@class ='buc_29210 buc_3oRFh']"; //Somu
	final String Selectprcbid = "//*[@class ='buc_24DYi buc_cz1dr']"; //Somu
	final String Selectbrand = "//*[@class ='buc_5ypoa buc_3SL_L buc_2psxF']";
	final String Select = "//*[@id=\"attribute\"]";
	final String Select1 = "//*[@Class ='buc_fODub buc_JldaV']";
	final String Selectattribute = "//*[@Class ='buc_knl5E _1G4AR']";
	final String out  ="//*[@class ='buc_ksxnl buc_kygMK']";
	final String Selectattribute1 =  "//*[@class=buc_YnJ1C]";
	final String SelectValueLink2 = "(//*[@id='value-link'])[2]";
	final String SelectValueLink3 = "(//*[@id='value-link'])[3]";
	final String SelectValueLink4 = "(//a[@id='value-link'])[4]";
	final String OperatorLink2 = "(//a[@id='operator-link'])[2]";
	final String OperatorLink3 = "(//a[@id='operator-link'])[3]";
	final String OperatorLink4 = "(//a[@id='operator-link'])[4]";
	final String NotEmpty = "NotEmpty";
	final String NotEmpty2 = "//*[@id=\'NotEmpty\']";
	final String Noemp ="(//*[@id=\"NotEmpty\"])[2]";
	final String NotEmpty3 = "(//li[@id='NotEmpty'])[3]";
	final String NotEquals2 = "(//li[@id='NotEqual'])[2]";
	final String ContainsAny1 = "(//li[@id='ContainsAny'])[1]";
	final String Contains1 = "(//li[@id='Contains'])[1]";
	final String Notcontainsany = "(//*[@id='NotContainsAny'])[2]";
	final String SelectValue_Resource = "//div[@id='Resource'][text()='Resource']";
	final String SelectValue_product = "//div[@id='Product'][text()='Product']";
	final String SelectValue_item = "//*[@id='Item']";
	final String Sourcing_type = "//*[@id=\'ProductSourcingType\']";
	final String Equals ="(//*[@id=\'Equals\'])[2]";
	final String External ="(//*[@id=\'value-list\']/div[3])[2]";
	final String AddDataConditionLink = "//a[@title='Add Data condition']";
	final String SystemLink2 = "(//a[@id='system-link'])[2]";
	final String SystemLink3 = "(//a[@id='system-link'])[3]";
	final String Businessmodel = "(//*[@id='ArticleBusinessModels'])[2]";
	//final String SystemLink4 = "(//a[@id='system-link'])[4]";
	final String SystemLink4 = "(//*[@id=\'system-link\'])[4]";
	final String SystemLink_Origin = "//a[@id='system-link'][text()='Origin']";
	final String EnterValueLink = "enter a value";
	final String EnterValueLink1 = "(//*[@id='operator-link'])[2]";
	final String Containsany = "//*[@id='ContainsAny']";
	final String ArticleLink = "(//*[@id='Data'])[1]";
	final String FlowersnPlants = "(//*[@id=\'ProductPlantAndFlowerStyle\'])[2]";
	final String ArticleCorporateID = "//*[@id='ArticleCorporateBrandID']";
	final String selectcoscheckbox = "//*[@id='value-list']/div[3]/input";
	final String ProductInfoLevel = "ProductInformationLevel";
	final String ProductMeasurements = "ProductMeasurements";
	final String ProductMeasurementsInternal2 = "(//div[@id='ProductMeasurementsInternal'])[2]";
	final String ValueInputBox = "//div[@class='query-row sub-row']/div[@class='query-link-container']/input[@type='text']";
	final String SearchButton = "search";
	final String QueryLocalesReceivedForPrint = "(//div[@id='ProductTranslationsReceivedPrint'])[2]";
	final String DivisionName_querycondition = "(//div[@id='ProductDivision'])[2]";
	final String QueryLocalesReceivedForEcom = "(//div[@id='ProductTranslationsReceived'])[3]";
	final String ProdEnrichmentStatus = "(//div[@id='ProductEnrichmentStatus'])[1]";
	final String EnrichStatusQualityChecked = "//div[@data-cvlkey='approved']";
	final String AssortmentType = "(//div[@id='ProductAssortmentType'])[2]";
	final String AssortmentType3 = "(//div[@id='ProductAssortmentType'])[3]";
	//final String PersonalCareAssortmentType = "//div[@data-cvlkey='personalcare']";
	final String PersonalCareAssortmentType = "//div[@data-cvlkey='000personalcare']";
	//final String ClothingAssortmentType = "//div[@data-cvlkey='clothing']";
	final String ClothingAssortmentType = "//div[@data-cvlkey='000clothing']";
	final String QualityCheckedPrint = "(//div[@id='ProductQualityCheckedPrint'])[2]";
	final String OperatorList_False = "//ul[@id='operator-list']/li[@id='IsFalse']";
	final String FootwearStyle = "(//div[@id='ProductFootwearStyle'])[1]";
	final String LanguageLink2 = "(//a[@id='language-link'])[2]";
	final String CloseIcon = "(//span[@id='close-icon'])[2]";
	final String Colorshades ="//*[@id=\'ArticleColourShades\']";
	final String PresentationProductType = "(//div[@id='ProductPresentationProductType'])[3]";
	//final String Shoes ="//*[@id='value-list']/div[402]";
	final String Shoes ="//*[@id='value-list']/div[403]/input";
	final String CorporateBrandID = "(//div[@id='ProductCorporateBrandID'])[2]";
	final String CosID = "//div[@data-cvlkey='001']";
	final String CBSmodel = "(//*[@id='value-list']/div[2]/input)[2]";
	
	// Overview Page
	// Elements---------------------------------------------------------------------------
	final String UsedInHnM_ICC_Channel = "//div[@id='channel-area-content']/div/span[text()='HnM_ICC_Channel']";
	final String NotUsedInChannel = "//div[@id='channel-area-content']/div/i[text()='Not used in any channels']";

	// Details Page
	// Elements---------------------------------------------------------------------------
	final String SizeLabel = "//div[@class='field-editor-wrap'][@fieldtypeid='ProductSizes']";
	final String SizeValue = "Fields_17_Value";
	final String FieldSet = "FieldSet";
	final String LongProdNameEditbutton = "(//i[@id='locale-string-edit-button'])[1]";
	final String LongProdNameEditLang = "(//select[@class='editLanguage'])[1]";
	//final String LongProdNameText = "//textarea[@name='Fields.6.Value']"; 
	final String LongProdNameText ="//div[@fieldtypeid='ProductNameLong']/fieldset/div[2]/div/div/div[2]/div[1]/table/tbody/tr[2]/td/textarea";
	final String ShortProdNameEditbutton = "(//*[@id=\"locale-string-edit-button\"])[2]";
	final String ShortProdNameEditLang = "(//select[@class='editLanguage'])[2]";
	//final String ShortProdNameText = "//textarea[@name='Fields.7.Value']";
	//OLD 7.4.22final String ShortProdNameText = "//*[@id='textc741_Fields_11_Value']";
	final String ShortProdNameText = "(//*[@id=\"category-field-container\"]/div[11]/fieldset/div[1]/div/div)[1]";
	final String LongProdDescEditbutton = "(//i[@id='locale-string-edit-button'])[3]";
	final String LongProdDescEditLang = "(//select[@class='editLanguage'])[3]";
	//final String LongProdDescText = "//textarea[@name='Fields.8.Value']";
	final String LongProdDescText = "//div[@fieldtypeid='ProductLongDescription']/fieldset/div[2]/div/div/div[2]/div[1]/table/tbody/tr[2]/td/textarea";
	final String LocalesSentForPrintText = "//div[@name='Fields_57_Value']/div/button/span";
	//final String LocalesSentForEComText = "//div[@name='Fields_57_Value']/div/button/span"; 
	final String LocalesSentForEComText = "(//*[@id='category-field-container']/div[5]/fieldset/div[1]/div/div)[4]";
	final String Locales_selectAll = "ms-select-all";
	final String Save_button = "//*[@id='entity-detail-settings-save-all-button']";
	final String Flowernplant ="//*[@id=\'category-field-container\']/div[48]/fieldset/div[1]/div/div/b";
	final String ColorShades ="//*[@id='category-field-container']/div[26]/fieldset/div[1]/div/div/text()";

	final String QCForPrint_True = "//input[@name='Fields_66_Value'][@value='True']";
	final String DueDatePrint = "Fields_73_Value";
	final String EnrichmentStatus_Label = "//div[@name='Fields_61_Value']/div/button/span";
	// final String EnrichmentStatus_QualityChecked = "//span[text()='QualityChecked']";
	//final String EnrichmentStatus_QualityChecked = "//input[@name='Fields_61_Value'][@value='approved']"; 
	final String EnrichmentStatus_QualityChecked = "//div[@fieldtypeid='ProductEnrichmentStatus']/fieldset/div[2]/div/ul/li/input[@value='approved']";
	final String InfoLevel = "//div[@name='Fields_75_Value']/div/button/span";
	//final String InfoLevelA = "//input[@name='Fields_75_Value'][@value='LevelA']";
	final String InfoLevelA = "//div[@fieldtypeid='ProductInformationLevel']/fieldset/div[2]/div/ul/li/input[@value='LevelA']";
	//final String InfoLevelB = "//input[@name='Fields_76_Value'][@value='LevelB']";
	final String InfoLevelB = "//div[@fieldtypeid='ProductInformationLevel']/fieldset/div[2]/div/ul/li/input[@value='LevelB']";
	final String InfoLevelHistoryButton = "//span[@fieldtypeid='ProductInformationLevel']";
	final String InfoLevel_zero = "//div[@class='item'][@data-cvlkey='LevelZero']";
	final String InfoLevel_A = "//div[@class='item'][@data-cvlkey='LevelA']";
	final String InfoLevel_B = "//div[@class='item'][@data-cvlkey='LevelB']";
	final String ProdTransMajorChange = "(//*[@id='category-field-container']/div[2]/fieldset/div[1]/div/div)[5]";
	final String ProdTransReceivedPrint = "//div[@fieldtypeid='ProductTranslationsReceivedPrint']";
	final String ProdTransReceivedEcom = "//div[@fieldtypeid='ProductTranslationsReceived']/fieldset/div[1]/div/div";
	final String ProdTransReceivedPrint_Text = "//div[@fieldtypeid='ProductTranslationsReceivedPrint']/fieldset/div/div/div[@class='field-editor-label']";
	final String ProdTransReceivedEcom_Text = "//div[@fieldtypeid='ProductTranslationsReceived']/fieldset/div/div/div[@class='field-editor-label']";
	final String ProdTransSentPrint_Text = "//div[@fieldtypeid='ProductTranslationsSentPrint']/fieldset/div/div/div[@class='field-editor-label']";
	final String LocalesToTrans = "//div[@name='Fields_54_Value']/div/button/span";
	//final String MeasurementInCm = "//input[@name='Fields_46_Value']";
	//final String MeasurementInCm = "//div[@fieldtypeid='ProductMeasurements']/fieldset/div[2]/div/input";
	
	final String MeasurementInCm = "(//*[@id='category-field-container']/div[1]/fieldset/div[1]/div/div)[5]";
	final String NoOfMCharts_Label = "//div[@fieldtypeid='ProductMeasurementNbOfMCharts']";
	//final String NoMeasurements_True = "//ul[@name='Fields_50_Value']/li/input[@value='True']";
	final String NoMeasurements_True ="//div[@fieldtypeid='ProductNoMeasurements']/fieldset/div[2]/div/ul/li[2]/input[@value='True']";
	//final String NoMeasurements_False = "//ul[@name='Fields_50_Value']/li/input[@value='False']";
	final String NoMeasurements_False ="//div[@fieldtypeid='ProductNoMeasurements']/fieldset/div[2]/div/ul/li[3]/input[@value='False']";
	//final String TransMajorChange_True = "//input[@name='Fields_54_Value'][@value='True']";
	//final String TransMajorChange_True = "//div[@fieldtypeid='ProductTranslationMajorChange']/fieldset/div[2]/div/ul/li[2]/input[@value='True']";
	final String TransMajorChange_True = "(//*[@Type='radio'])[15]";
	final String TranslationMajor="(//*[@id='category-field-container']/div[2])[5]";
	final String SelectedLocale = "(//li[@data-name='selectItem'][@checked='checked'])[1]";
	//final String ProdWarning = "Fields_43_Value";
	final String ProdWarning ="//div[@fieldtypeid='ProductWarning']/fieldset/div[2]/div/input";
	//final String AssortmentType_Clothing = "//input[@name='Fields_19_Value'][@value='clothing']";
	final String AssortmentType_Clothing ="//*[@id='c614_Fields_19_Value']/div/button/span";
	//final String AssortmentType_Clothing = "//*[@id='c3631_Fields_19_Value']";
	final String SleeveStyle_Dropdown = "//div[@cvlid='SleeveStyle']/div/button";
	//final String SleeveStyle_Dropdown = "//*[@id='c2955_Fields_22_Value']/div/button/div";
	final String SleeveStyle_SelectAll = "//div[@cvlid='SleeveStyle']/div/div/ul/li[@class='ms-select-all']";
	final String NeckLineStyle_Dropdown = "//div[@cvlid='NecklineStyle']/div/button";
	final String NeckLineStyle_SelectAll = "//div[@cvlid='NecklineStyle']/div/div/ul/li[@class='ms-select-all']";
	final String CollarStyle_Dropdown = "//div[@cvlid='CollarStyle']/div/button";
	final String CollarStyle_SelectAll = "//div[@cvlid='CollarStyle']/div/div/ul/li[@class='ms-select-all']";
	final String ClothingStyle_Dropdown = "//div[@cvlid='ClothingStyle']/div/button";
	final String ClothingStyle_SelectAll = "//div[@cvlid='ClothingStyle']/div/div/ul/li[@class='ms-select-all']";
	final String GarmentLength_Dropdown = "//div[@cvlid='GarmentLength']/div/button";
	// final String GarmentLength_SelectAll =
	// "select-all-cvl-values-checkbox-ProductGarmentLength";
	final String GarmentLength_SelectAll = "//div[@cvlid='GarmentLength']/div/div/ul/li[@class='ms-select-all']";
	final String SleeveLength_SelectAll = "select-all-cvl-values-checkbox-ProductSleeveLength";
	final String Heelheight_SelectAll = "select-all-cvl-values-checkbox-ProductHeelHeight";
	final String WaistRise_SelectAll = "select-all-cvl-values-checkbox-ProductWaistRise";
	//final String Style = "//div[@name='Fields_68_Value']/div/button";
	final String Style = "//div[@fieldtypeid='ProductStyle']/fieldset/div[2]/div/div/div/button";
	//final String DescLength = "//div[@name='Fields_72_Value']/div/button";
	final String DescLength = "//div[@fieldtypeid='ProductDescriptiveLength']/fieldset/div[2]/div/div/div/button";
	//final String Style_placeholder = "//div[@name='Fields_71_Value']/div/button/span";
	final String Style_placeholder = "//div[@fieldtypeid='ProductStyle']/fieldset/div[2]/div/div/div/button/span";
	//final String DescLength_placeholder = "//div[@name='Fields_72_Value']/div/button/span";
	final String DescLength_placeholder = "//div[@fieldtypeid='ProductDescriptiveLength']/fieldset/div[2]/div/div/div/button/span";
	final String InfoLevel_Title = "//div[@fieldtypeid='ProductInformationLevel']";
	final String ProductTranslationLanguages_Text = "//div[@fieldtypeid='ProductTranslationLanguages']";
    final String Richtexteditor = "//div[@class='note-editable']";
    final String SaveRCTE = "//*[@id='save-button']";
    final String Enrichment = "//*[@id='c15522_Fields_98_Value']/li[5]']";
    final String LongProdDescRCTE = "(//*[@id='category-field-container']/div[11])[1]";
    
	// RGB   Page Elements
	// -------------------------------------------------------------------------------------
	final String RGBImage = "color-picker-container";
	final String ColorPickerImg = "//div[@id='color-picker-container']/div/canvas";
	final String SortBy = "sort-order";
	final String PreviewColor = "//div[@id='preview']/span";
	final String ExternalColor = "//div[@id='external']/span";
	final String InternalColor_Area = "//div[@id='internal']";
	final String InternalColor = "//div[@id='internal']/span";
	final String Colorshade ="//*[@id=\'category-field-container\']/div[26]/fieldset/div[1]/div/div";

	// Composition Page
	// Elements---------------------------------------------------------------------
	final String SingleMode = "//*[@id=\"mode-single\"]";
	final String MultiMode = "//*[@id=\"mode-multuple\"]";
	//final String AddMaterialTypeButton = "//*[@id=\"add-material-button\"]";
	final String AddMaterialTypeButton = "//*[@id='data-table']/thead/tr/th[2]/div/button";
	final String AddCompositionTypeButton = "add-composition-button";
	final String AddCompositionTypeDropDown = "//*[@id=\"add-modal\"]/div/div/div[2]/form/div[1]/div/button/span";
	final String AddCompositionTypeSearchBar = "//*[@id=\"add-modal\"]/div/div/div[2]/form/div[1]/div/div/div/input";
	final String AddCompositionDoneButton = "btn btn-default btn-success";
	final String MaterialPercentageValue = "//*[@id=\"data-table\"]/tbody/tr/td/div/input";
	//final String Save = "//*[@id=\"save-button\"]";
	final String Save = "//*[@id='save-button']/text()";
	final String CopyButton = "//*[@id=\"copy-to-button\"]";
	final String AddMaterial = "//*[@id='data-table']/thead/tr/th[2]/div/div/ul/li[71]/label/input";
	//*[@id="data-table"]/thead/tr/th[2]/div/div/ul/li[71]/label/input
	// Warning Page
	// Elements----------------------------------------------------------------------
	final String ProdHazmatClass = "txtHazmatClass";
	final String ProdHazmatUNCode = "//span[@id='txtHazmatUnCode']";
	final String ProdHazmatDGDesc = "txtHazmatDGDesc";
	final String AddWarningTypeButton = "add-warning-button";
	final String WarningDropDownList = "//*[@class='form-control']";
	//final String WarningDropDownList = "(//*[@class='form-control'])[1]";
    //final String WarningDropDownList = "form-control";
	//final String WarningDropDownList = "/html/body/div[4]/div/div/div/div[2]/form/div[1]/select";
	final String WarningDoneButton = "(//*[@class='btn btn-default btn-success'])[1]";
	//final String WarningDoneButton = "/html/body/div[4]/div/div/div/div[2]/form/div[2]/button[2]";
	// Measurement Page
	// Elements----------------------------------------------------------------
	final String SelectedSize = "selected-size";
	final String ClearMeasurement = "clearMeasurement";
	final String NoMeasurementsToenrich = "no-measurement";

	// Magnifier Page
	// Elements------------------------------------------------------------------
	final String Slider = "//*[@id='slider-range-max']/span";
	final String MagnifierImage = "the-image";
	final String NoImagesText = "//body[text()='No images available']";

	
	// Media Page
	// Elements------------------------------------------------------------------
	final String MediaSlider = "//*[@id='lightboard-slider']/span";
	final String MediaImage = "//div[@class='thumbnail lightboard-card-wrap']/div[@class='lightboard-wrapper']/img";
	final String ShowAll_Checkbox = "show-all";
	
	
	// Includes Page
	// Elements-------------------------------------------------------------------
	final String LinkedArticlesCount = "//div[@id='ProductArticle']/div[@id='relation-section-container']/div";

	// CreateNewRAElements----------------------------------------------------------------------
	final String RelationType_VisuallyMatching = "//label[text()='Visually matching']";
	final String RelationType_notset = "//label[text()='(not set)'][1]";
	final String RT_VisuallyMatching_RadioButton = "//ul[@name='Fields_0_Value']/li[2]/input";
	final String RT_Notset_RadioButton = "//ul[@name='Fields_0_Value']/li[1]/input";
	final String RelationKeywordsPlaceholder = "placeholder";
	final String RelationKeyword_close = "ms-choice";
	final String RelationKeywords_Suit = "//input[@type='checkbox'][@value='suit']";
	final String RelationKeywords_Bikini = "//input[@type='checkbox'][@value='bikini']";
	final String RelationKeywords_Coord = "//input[@type='checkbox'][@value='coord']";
	final String RelationKeywords_Coffeeset = "//input[@type='checkbox'][@value='coffeeset']";
	final String RelationKeywords_Teaset = "//input[@type='checkbox'][@value='teaset']";
	final String RelationKeywords_Dinnerwareset = "//input[@type='checkbox'][@value='dinnerwareset']";
	final String RelationKeywords_Partwear = "//input[@type='checkbox'][@value='partywear']";
	final String ReadyToPublish_True = "(//input[@type='radio'][@name='Fields_6_Value'])[2]";
	final String ReadyToPublish_False = "(//input[@type='radio'][@name='Fields_6_Value'])[3]";
	final String Baseload_True = "(//input[@type='radio'][@name='Fields_7_Value'])[2]";
	final String Baseload_False = "(//input[@type='radio'][@name='Fields_7_Value'])[3]";
	final String Resend_True = "(//input[@type='radio'][@name='Fields_8_Value'])[2]";
	final String Resend_False = "(//input[@type='radio'][@name='Fields_8_Value'])[3]";
	final String SaveButton_RA = "save-form-button";
	final String NewRA = "card-section-title-text";
	final String RelatedArticle = "card-text1";
	final String RelatedArticlOverview = "tab-overview";
	final String InternalRelationName = "Fields_1_Value";
	final String AccessDeniedAlert = "//div[@class='alertify-alert-header']/div[text()='Access denied']";
	final String DeleteButton = "//span[@id='delete-button'][@title='Delete']";

	// ArticlePageElements-----------------------------------------------------------------------------
	final String ArticleNumber = "Fields_0_Value";
	//final String ArticleHazmatDGDesc = "Fields_32_Value";
	final String ArticleHazmatDGDesc = "//div[@fieldtypeid='ArticleHazmatDGDescription']/fieldset/div[2]/div/input";
	//final String ArticleHazmatClass = "Fields_30_Value";
	final String ArticleHazmatClass = "//div[@fieldtypeid='ArticleHazmatClass']/fieldset/div[2]/div/input";
	//final String ArticleHazmatUNCode = "Fields_31_Value";
	final String ArticleHazmatUNCode = "//div[@fieldtypeid='ArticleHazmatUNCode']/fieldset/div[2]/div/input";
	final String EditCancel = "cancel-form-button";
	//final String ArticleSafetyInfo = "Fields_29_Value";
	final String ArticleSafetyInfo = "//div[@fieldtypeid='ArticleWarning']/fieldset/div[2]/div/input";
	//final String CompositionList = "Fields_37_Value";
	final String CompositionList = "//div[@fieldtypeid='ArticleCompositionList']/fieldset/div[2]/div/input";
	final String TransMajorChange_Text = "//div[@fieldtypeid='ArticleTranslationMajorChange']";
	//final String InternalRGB = "Fields_27_Value"; 
	final String InternalRGB = "//div[@fieldtypeid='ArticleColorRgbInternal']/fieldset/div[2]/div/input";
	//final String RGB = "Fields_28_Value";
	final String RGB = "//div[@fieldtypeid='ArticleColorRgb']/fieldset/div[2]/div/input";
	final String ArticleSafetyInfo_Text = "//div[@fieldtypeid='ArticleWarning']";
	final String Businessmodellabel = "//*[@id='category-field-container']/div[22]/fieldset/div[1]/div/div";
	//final String Flowersnplants ="//*[@id=\'fields\']";
	final String Content ="//*[@id=\'contentwrapper\']";
	final String List = "(//*[@id='Category2-show'])[2]";
	//final String CBScheckbox ="/html/body/div[6]/div/div/div/div[2]/div/div/div[2]/div/div[1]/div/form/div[22]/div[22]/fieldset/div[2]/div/ul/li[3]/input";
	final String CBScheckbox ="//input[@type='checkbox'][@value='cbs']";
	final String CBSlabel ="//*[@id='category-field-container']/div[22]";
	final String Savefind ="//*[@id='entity-detail-settings-save-all-button']";
	final String ClickIncludedIn ="//*[@id='tab-includedin']";
	final String Productininclude ="//*[@id='ProductArticle']";
	final String includelink ="(//*[@id='contextmenu'])[145]";
	final String includeEdit ="//*[@id='edit-entity']/span[2]";
	final String ProductFieldCBS ="(//*[@id='category-field-container']/div[16]/fieldset/div[1]/div/div)[3]";
	final String OverviewCBS ="//*[@id='tab-overview']";
	final String rowcontent ="//*[@id='control-row-content']/span[2]//*[@id='tab-details']";
	final String Cbsscreen ="//*[@id='category-field-container']/div[22]";
	
	// LoginElements-----------------------------------------------------------------------------
	final String Username = "login";
	final String Auth = "//input[@type='email']";
	final String Password = "password";
	final String next = "action";
	final String QQuery ="//*[@class ='buc_OP8QX']";
	final String Mail ="//*[@class ='form-group col-md-24']";
	final String Submit = "button[type='submit']";
//	final String nextL = "//*[@id='idSIButton9']";
	// PortalElements----------------------------------------------------------------------------
	final String Enrich = "//*[@class='_3q7Ia']";
	final String TopHeaderTitle = "(//*[@class ='buc_C1UTy'])[1]";
	final String SearchBar = "//*[@class ='buc_26G3c']";
	final String ProductButton = "(//*[@class='_37WrX'])[2]";
	final String Filtertab ="(//*[@class='buc_w03hw'])[1]";
	final String SearchBarSubmit = "(//*[@class='buc_34Uex buc_2I80X buc_26poZ buc_3FzGw zYhqj'])[1]";
	final String LoadingData_Msg = "//div[@id='loading']/div/h2[text()='Loading data']";
	final String AlertOK_button = "alertify-ok";
	final String CardSectionContainer = "card-section-container";
	final String ParentWorkareaNodes = "//*[@id='s_00000000-0000-0000-0000-000000000000']/"
			+ "ul[@class='jstree-children']/li[@role='treeitem']";
	final String WorkareaErrMsg = "alertify-alert-message";
	final String CreateNewEntity_Hamburger = "app-tools-header";
	final String RelatedArticlesEntity = "RelatedArticles";
	final String ProductImage = "(//*[@class='card-wrap-large ui-draggable ui-draggable-handle'])[1]";
	//final String ProductImage = "//*[@id='Item']/div[2]";
	final String ProductImage1 = "(//div[@class='card-text1'])[1]";
	final String ArticleImage = "(//*[@class='card-wrap-large ui-draggable ui-draggable-handle'])[1]";
	final String ResourceImage = "//img[@title='Resource']";
	final String NoResouce = "//h4[text()='Query (0)']";
	final String QueryEditorhead ="//*[@class='_5gLYO']";
	final String Edit_query_button = "//*[@class ='buc_Tc3FM buc_2BQTJ']";
	final String SystemLink_ResourceAssetId = "ResourceAssetId";
	// final String productDivision = "ProductDivision";
	// final String includedInArticles =
	// "//div[@class='card-wrap']/div[@class='card-text1'][@title=articlenumber]";
	final String IncludeInTab = "//*[@id='tab-includedin']";
	final String Card_text1 = "//div[@class='card-text1']";
	final String ArticleCard_text1 = "(//div[@class='card-text1'])[1]";
	final String QueryEditor = "queryEditor";
	final String NoSearchResult = "//div[@class='workarea-header']/div[@id='search-result-query']/h4[text()='Search (0)']";

	// ProductPageElements------------------------------------------------------------------------
	final String OverviewTab = "tab-overview";
	final String DetailTab = "//div[@class='entity-row-view-height']//span[@id='tab-details']";
	final String DetailTabCBS = "//*[@id='tab-details']";
	final String MagnifierTab = "tab-custom-editor-5";
	final String CompositionTab = "tab-custom-editor-2";
	final String RGBTab = "tab-custom-editor-1";
	final String MeasurementTab = "tab-custom-editor-4";
	final String WarningTab = "tab-custom-editor-3";
	final String MediaTab = "tab-media";
	final String IncludesTab = "tab-includes";
	final String SaveButton = "//*[@id='save-button']";
	final String AppMenu_launcher = "//*[@class ='_2tDVo'] ";
	final String PortalApp = "//*[@class ='_2rgPc']";
	final String RichTextEditorTab = "tab-custom-editor-6";
	//final String DetailTabRCTE = "//*[@id='tab-details']";/html/body/div[7]/div/div/div/div[1]/div[2]/span[2]/span[2]
	final String DetailTabRCTE = "/html/body/div[7]/div/div/div/div[1]/div[2]/span[2]/span[2]";
	
	
	// RelatedArticleElements---------------------------------------------------------------------

	final String IncludesTabLink = "tab-includes";
	final String SearchBox = "workareasearchquery";
	final String SearchBoxEnter = "workareasearch";
	final String Article = "//img[@title='Article']";
	final String Relation_section_container = "relation-section-container";

}
