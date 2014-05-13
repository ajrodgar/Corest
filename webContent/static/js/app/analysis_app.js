var app = app || {};

(function ($) {
    'use strict';

    // CyclomaticComplexity Model
    // ----------
    app.CyclomaticComplexity = Backbone.Model.extend({

        urlRoot: '/api/cyclomaticcomplexity',

        container: "#cyclomatic-complexity",

        defaults: function () {
            return {
                id: null,
                module: "",
                value: 0
            };
        }

    });

    var CyclomaticCollection = Backbone.Collection.extend({
        model: app.CyclomaticComplexity,

        url: '/api/cyclomaticcomplexity'
    });

    // Global collection of **CyclomaticCollection**.
    app.CyclomaticCollection = new CyclomaticCollection();

    // LackOfCohesion Model
    // ----------
    app.LackOfCohesion = Backbone.Model.extend({

        urlRoot: '/api/lackofcohesion',

        container: "#lack-of-cohesion",

        defaults: function () {
            return {
                id: null,
                module: "",
                value: 0
            };
        }

    });

    var LackCohesionCollection = Backbone.Collection.extend({
        model: app.LackOfCohesion,

        url: '/api/lackofcohesion'
    });

    // Global collection of **LackCohesionCollection**.
    app.LackCohesionCollection = new LackCohesionCollection();

    // CodeLines Model
    // ----------
    app.CodeLine = Backbone.Model.extend({

        urlRoot: '/api/codelines',

        container: "#code-lines",

        defaults: function () {
            return {
                id: null,
                module: "",
                value: 0
            };
        }

    });

    var CodeLines = Backbone.Collection.extend({
        model: app.LackOfCohesion,

        url: '/api/codelines'
    });

    // Global collection of **CodeLines**.
    app.CodeLines = new CodeLines();

    // ClassCount Model
    // ----------
    app.ClassCount = Backbone.Model.extend({

        urlRoot: '/api/classcount',

        container: "#class-count",

        defaults: function () {
            return {
                id: null,
                module: "",
                value: 0
            };
        }

    });



    // MetricItemView View - Compatible for (module, value) models.
    // --------------
    app.MetricItemView = Backbone.View.extend({
 
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
            this.listenTo(app.CyclomaticCollection, 'add', this.addOne);
            this.listenTo(app.LackCohesionCollection, 'add', this.addOne);
            this.listenTo(app.CodeLines, 'add', this.addOne);

            app.CyclomaticCollection.fetch();
            app.LackCohesionCollection.fetch();
            app.CodeLines.fetch();
        },

        addOne: function (metricModel) {
            var view = new app.MetricItemView({
                model: metricModel
            });
            
            this.getContainerElement(metricModel).append(view.render().el);
        },

        getContainerElement: function(metricModel){
            return this.$(metricModel.container).find("ul.data");
        }
    });
})(jQuery);