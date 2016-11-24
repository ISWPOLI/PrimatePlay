$ ->
  $.get "/products", (products) ->
    $.each products, (index , product) ->
      html =
        '<div class="polaroid col-md-3 col-md-offset-1" id="cell">' +
          '<img src="/'+product.id+'" alt="Norway">' +
          '<div class="container">' +
          '<p>'+product.price+'</p>' +
          '<button type="submit" class="btn btn-default"><img src="/car" alt="Norway"></button>' +
          '</div>'+
          '</div>'
      $('#basicContainerCatalog').append html