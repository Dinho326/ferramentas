$('#modalExclusao').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	var codigo = button.data('codigo');
	var nome = button.data('nome');
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')){
		action += '/';
	}
	
	form.attr('action',action+ codigo);
	
	modal.find('.modal-body span')
	.html('Tem certeza de que deseja excluir <strong>' +nome+'</strong>?');
	
});
//toda vez que carregar a página
$(function() {
	
	$('[rel="tooltip"]').tooltip();
});