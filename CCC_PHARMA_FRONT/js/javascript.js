function tableshowhide(a, b, c){

	len = menu.childElementCount;

	closeAll();

	for(i = 0; i < len; i++){
		menu.children[i].onclick=function(){
			closeAll();
			all.children[this.id].style.display="block";
		}
	}

	function closeAll(){
		for(i = 0; i < all.childElementCount; i++){
			all.children[i].style.display="none";
		}
	}

	menu.children[c].click();
}

tableshowhide("menu", "all", "love");