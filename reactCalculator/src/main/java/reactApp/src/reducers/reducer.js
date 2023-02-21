

const initialState = {

  isLoading: false,

  list: [],

  name: "This is EXAMPLES!!!!!",

};

export default (state = initialState, action) => {

  switch (action.type) {

    case 'REQUEST_EXAMPLES': {

      return {

        ...state,

        isLoading: true,

      };

    }

    case 'RECEIVE_EXAMPLES': {

      const {

        examples,

      } = action;

      return {

        ...state,

        isLoading: false,

        list: examples,

      };

    }

    default: return state;

  }

};