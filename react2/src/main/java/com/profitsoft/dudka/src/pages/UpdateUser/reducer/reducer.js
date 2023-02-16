const initialState = {
    isLoading: false,
    userById: [],
    name: "User!",
  };
  export default (state = initialState, action) => {  
    switch (action.type) {
      case 'REQUEST_USER': {
        return {
          ...state,
          isLoading: true,
        };
      }
      case 'RECEIVE_USER': {
        const {
          userId,
        } = action;
        return {
          ...state,
          isLoading: false,
          userById: userId,
        };
      }
      default: return state;
    }
  };