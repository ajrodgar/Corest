var app = app || {};

(function ($) {
    'use strict';

    // Rank Model
    // ----------
    app.Rank = Backbone.Model.extend({

        urlRoot: '/api/rank',

        defaults: function () {
            return {
                id: null,
                module: "",
                value: 0
            };
        }

    });

    var Ranking = Backbone.Collection.extend({
        model: app.Rank,

        url: '/api/rank'
    });

    // Create our global collection of **Ranking**.
    app.Ranking = new Ranking();

    // Analysis View
    // --------------
    app.RankItemView = Backbone.View.extend({
 
        tagName: 'li',

        template: _.template("<%= module %> <span class='label label-success'><%= value %></span>"),

        render: function () {
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },
    });

    // Analysis View
    // --------------
    app.AnalysisView = Backbone.View.extend({
 
        el: "#analysis-content",

        initialize: function () {
            this.listenTo(app.Ranking, 'add', this.addOne);

            app.Ranking.fetch();
        },

        addOne: function (rank) {
            var view = new app.RankItemView({
                model: rank
            });
            this.$("#rank ul.data").append(view.render().el);
        }
    });
})(jQuery);